import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.*;

import org.com.model.Task;

@Component
public class ReturnTasks {

    private static JSONObject sortedByParentTasks = null;
    private static JSONArray tasksTree = null;
    private static JSONObject taskChildrenObject;

    /**
     * Generates JSON String to return in the modelAndView
     * @param events
     * @return
     * @throws JSONException 
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */

    public static String mapOK(List<Task> events) throws JSONException, JsonGenerationException, JsonMappingException, IOException{
        tasksTree = null;
        tasksTree = new JSONArray();
        sortedByParentTasks = null;
        sortedByParentTasks = new JSONObject();
        tasksTree = makeTree(events);

        return tasksTree.toString();
    }

    private static JSONArray makeTree(List<Task> list) throws JSONException, JsonGenerationException, JsonMappingException, IOException{

        Iterator<Task> listIterator = list.iterator();
        String parentId;

        while(listIterator.hasNext()){
            Task task = listIterator.next();
            JSONArray equalParentId;
            parentId = ""+task.getParentId();
            String json = new ObjectMapper().writeValueAsString(task);
            JSONObject taskJSON = new JSONObject(json);

            if (sortedByParentTasks.has(parentId)){
                sortedByParentTasks.accumulate(parentId, taskJSON);
            } else {
                equalParentId = new JSONArray();
                equalParentId.put(taskJSON);
                sortedByParentTasks.put(parentId, equalParentId);
            }
        }

        addNodes(sortedByParentTasks.getJSONArray("null"));

        return tasksTree;
    }

    private static void addNodes(JSONArray nodes) throws JSONException{
        for(int i=0, l=nodes.length(); i<l; i++){
            taskChildrenObject = nodes.getJSONObject(i);
            listHierarchy(taskChildrenObject);
            tasksTree.put(taskChildrenObject);
        }
    }

    private static void listHierarchy(JSONObject task) throws JSONException{
        JSONArray childrenArray = new JSONArray();
        JSONArray childNodes = new JSONArray();

        try {
            childNodes = sortedByParentTasks.getJSONArray(""+task.get("Id"));
        }catch(JSONException e){} 

        if (childNodes.length() > 0){
            for (int i=0, l=childNodes.length(); i<l; i++) {
                JSONObject childObject = childNodes.getJSONObject(i);
                childrenArray.put(childObject);
                try{
                    task.put("children", childrenArray);
                    task.put("leaf", false);
                }catch(JSONException e){}

                listHierarchy(childObject);
            }           
        }
    }

    /**
     * Generates modelMap to return in the modelAndView in case
     * of exception
     * @param msg message
     * @return
     */
    public static String mapError(String msg){

        Map<String,Object> modelMap = new HashMap<String,Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);

        return modelMap.toString();
    } 
}