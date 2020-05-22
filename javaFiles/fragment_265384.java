import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;

variableMap.put("Authorization", Variables
                              .objectValue(authorization)
                                  // tells the engine to use java serialization for persisting the value 
                              .serializationDataFormat(SerializationDataFormats.JAVA)  
                              .create());