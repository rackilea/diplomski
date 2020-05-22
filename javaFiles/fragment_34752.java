import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReference {
    Object data;

    public JsonReference(String buildFromString){
        try {
            data = new JSONObject(buildFromString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(data == null){
            try {
                data = new JSONArray(buildFromString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getAbstractJsonObject(){
        return data;
    }

    public List<String> parseForData(String data,boolean removeDuplicates){
        Traverser valFinder = new Traverser(0);
        valFinder.setValues(data, removeDuplicates);
        valFinder.traverseForStringValue(this.data);
        return valFinder.foundInstances;
    }

    class Traverser{
        List<String> foundInstances = new ArrayList<String>();
        String value;
        boolean removeDuplicates;

        public Traverser(int type){

        }

        public void setValues(String value,boolean removeDuplicates){
            this.value = value;
            this.removeDuplicates = removeDuplicates;
        }

        public void traverseForStringValue(Object root){

            if(root == null){
                return;
            }
            else if(root instanceof JSONObject){
                JSONObject self = (JSONObject)root;

                //if the key exists in this object.. save it!
                if(self.has(value)){
                    try {
                        if(!removeDuplicates || notRepeat(self.getString(value)))
                            foundInstances.add(self.getString(value));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return;
                }

                //otherwise, see if you can dive deeper..
                JSONArray names = self.names();
                for(int i=0;i<names.length();i++){
                    String temp = null;
                    try{
                        temp = names.getString(i);
                    }
                    catch(JSONException e){
                        e.printStackTrace();
                    }
                    if(temp != null){
                        try {
                            if(self.get(temp) instanceof JSONObject || self.get(temp) instanceof JSONArray)
                                traverseForStringValue(self.get(temp));
                            else if(self.get(temp) instanceof String){
                                if(!removeDuplicates || notRepeat(self.getString(value)))
                                    foundInstances.add(self.getString(value));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
            else if(root instanceof JSONArray){
                JSONArray self = (JSONArray)root;

                //iterate through the array..
                for(int i=0;i<self.length();i++){
                    Object temp = null;
                    try {
                        temp = self.get(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if(temp != null && temp != JSONObject.NULL){

                        if(temp instanceof JSONObject || temp instanceof JSONArray)
                            traverseForStringValue(temp);
                        else if(temp instanceof String && ((String)temp).contains(value)){
                            try {
                                if(!removeDuplicates || notRepeat(self.getString(i)))
                                    foundInstances.add(self.getString(i));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
            }
        }

        private boolean notRepeat(String s){
            for(String item : foundInstances){
                if(item.equals(s))
                    return false;
            }
            return true;
        }
    }
}