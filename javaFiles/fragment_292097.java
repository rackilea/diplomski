package utils.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class ReapplyJenaPrefixes {

    public String reapplyPrefixes(String jsonString) throws IOException {
        ObjectMapper jacksonParser = new ObjectMapper();
        JsonNode jsonNode = jacksonParser.readTree(jsonString);

        Map<String, String> prefixMap = buildPrefixedTagMap(jsonNode);
        applyPrefixes(jsonNode, prefixMap);

        return jacksonParser.writeValueAsString(jsonNode);
    }

    public void reapplyPrefixes(JsonNode node) {
        Map<String, String> prefixMap = buildPrefixedTagMap(node);
        applyPrefixes(node, prefixMap);
    }

    private Map<String, String> buildPrefixedTagMap(JsonNode node) {
        Map<String, Boolean> filteredWords = new HashMap<String, Boolean>();
        filteredWords.put("subClassOf", true);

        JsonNode contextNode = node.get("@context");
        List<Entry<String, String>> tagList = new ArrayList<Entry<String, String>>();
        Map<String, String> prefixMap = new HashMap<String, String>();
        Map<String, String> prefixedTagMap = new HashMap<String, String>();
        Iterator<Entry<String, JsonNode>> iterator = contextNode.fields();

        JsonNode currentNode;
        String currentNodeName;
        EntryImpl<String, String> tagEntry;
        while(iterator.hasNext()) {
            Entry<String, JsonNode> e = iterator.next();
            currentNode = e.getValue();
            currentNodeName = e.getKey();
            if(currentNode.isTextual()) {
                prefixMap.put(currentNode.textValue(), currentNodeName);

            } else if(!filteredWords.containsKey(currentNodeName)) {
                tagEntry = new EntryImpl<String, String>(currentNodeName, currentNode.get("@id").asText());
                tagList.add(tagEntry);
            }
        }

        String tagName;
        String namespace;
        String prefix;
        for(Entry<String, String> e : tagList) {
            tagName = e.getKey();
            namespace = e.getValue();

            // strip the tagName
            namespace = namespace.substring(0, namespace.length() - tagName.length());

            // lookup the prefix
            prefix = prefixMap.get(namespace);

            prefixedTagMap.put(tagName, prefix+":"+tagName);
        }

        return prefixedTagMap;
    }

    private void applyPrefixes(JsonNode node, Map<String, String> prefixMap) {
        JsonNode contextNode = node.get("@graph");

        ObjectNode currentNode = null;
        String prefixedTag = null;
        String fieldName = null;

        JsonNode topLevelFieldNode = null;
        Iterator<String> topLevelFieldNameIterator = null;
        List<String> topLevelFieldNameList;

        JsonNode subLevelFieldNode = null;
        Iterator<String> subLevelFieldNameIterator = null;
        List<String> subLevelFieldNameList;

        Iterator<JsonNode> arrayIterator = contextNode.elements();
        while(arrayIterator.hasNext()) {
            currentNode = (ObjectNode)arrayIterator.next();

            // Can't modify an iterator while iterating so store the field names in a list first
            topLevelFieldNameIterator = currentNode.fieldNames();
            topLevelFieldNameList = new ArrayList<String>();
            while(topLevelFieldNameIterator.hasNext()) {
                fieldName = topLevelFieldNameIterator.next();
                if(fieldName.charAt(0) != '@') {
                    topLevelFieldNameList.add(fieldName);
                }
            }

            for(String topLevelFieldName : topLevelFieldNameList) {

                topLevelFieldNode = currentNode.get(topLevelFieldName);

                prefixedTag = prefixMap.get(topLevelFieldName);
                if(prefixedTag != null

                        // Data tags don't seem to have prefixes on them
                        && (topLevelFieldNode.isTextual()
                        && !topLevelFieldNode.textValue().startsWith("data:"))) {
                    currentNode.remove(topLevelFieldName);
                    currentNode.set(prefixedTag, topLevelFieldNode);
                }

                if(topLevelFieldNode.isObject()) {
                    // Can't modify an iterator while iterating so store the field names in a list first
                    subLevelFieldNameIterator = topLevelFieldNode.fieldNames();
                    subLevelFieldNameList = new ArrayList<String>();
                    while(subLevelFieldNameIterator.hasNext()) {
                        fieldName = subLevelFieldNameIterator.next();
                        if(fieldName.charAt(0) != '@') {
                            subLevelFieldNameList.add(fieldName);
                        }
                    }

                    for(String subLevelFieldName : subLevelFieldNameList) {
                        subLevelFieldNode = topLevelFieldNode.get(subLevelFieldName);

                        prefixedTag = prefixMap.get(topLevelFieldName);
                        if(prefixedTag != null) {
                            ((ObjectNode)topLevelFieldNode).remove(subLevelFieldName);
                            ((ObjectNode)topLevelFieldNode).set(prefixedTag, subLevelFieldNode);
                        }
                    }
                }
            }
        }
    }

    private class EntryImpl<K, V> implements Entry<K, V> {

        private K k;
        private V v;

        public EntryImpl(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        @Override
        public V setValue(V value) {
            V oldV = v;
            v = value;
            return oldV;
        }

    }
}