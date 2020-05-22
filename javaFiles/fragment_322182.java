import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJacksonTyping {

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Response<TaskData> taskResponse = new Response<TaskData>();
        TaskData taskData = new TaskData();
        taskData.setTaskTitle("Some title");
        taskResponse.setData(taskData);
        Response<SubmitData> submitResponse = new Response<SubmitData>();
        SubmitData submitData = new SubmitData();
        submitData.setSubmitValue(256);
        submitResponse.setData(submitData);
        StringWriter sw = new StringWriter();
        mapper.writeValue(sw, taskResponse);
        String taskResponseJson = sw.toString();
        mapper.writeValue(sw = new StringWriter(), submitResponse);
        String submitResponseJson = sw.toString();
        Response<TaskData> deserializedTaskResponse = mapper.reader(new TypeReference<Response<TaskData>>() {
        }).readValue(new StringReader(taskResponseJson));
        Response<SubmitData> deserializedSubmitResponse = mapper.reader(new TypeReference<Response<SubmitData>>() {
        }).readValue(new StringReader(submitResponseJson));
        System.out.println(deserializedTaskResponse.getData().getTaskTitle());
        System.out.println(deserializedSubmitResponse.getData().getSubmitValue());

    }

    public static class Response<T> {
        private T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

    public static class TaskData {
        private String taskTitle;

        public String getTaskTitle() {
            return taskTitle;
        }

        public void setTaskTitle(String taskTitle) {
            this.taskTitle = taskTitle;
        }
    }

    public static class SubmitData {
        private int submitValue;

        public int getSubmitValue() {
            return submitValue;
        }

        public void setSubmitValue(int submitValue) {
            this.submitValue = submitValue;
        }
    }

}