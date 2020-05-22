package test;

import test.ACE.Inheritance;
import test.ACE.Right;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJacksonEnum {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        ACE ace= new ACE();
        ace.getAccessrights().add(Right.add_file);
        ace.getAccessrights().add(Right.add_subdir);
        ace.getInherit_flags().add(Inheritance.container_inherit);
        ace.getInherit_flags().add(Inheritance.inherit_only);
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(
                DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        System.out.println(mapper.writeValueAsString(ace));
        String serializedFormREST="{\"accessrights\":[\"std_synchronize\",\"add_subdir\"],\"inherit_flags\":[\"container_inherit\",\"inherit_only\"]}";
        ACE deserializedAce= mapper.readValue(serializedFormREST, ACE.class);
        System.out.println(mapper.writeValueAsString(deserializedAce));
    }


}