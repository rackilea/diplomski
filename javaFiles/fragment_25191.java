Imports: {
import static gate.Utils.*;
}
Phase:usingJAVAinRHS  
Input:  Lookup Sentence  
Options: control = appelt
Rule: javainRHS1  
(  
{Sentence contains {Lookup.majorType == Team}}  
)  
:team  
-->  
{  
    gate.AnnotationSet team = (gate.AnnotationSet)bindings.get("team"); 
    gate.FeatureMap features = Factory.newFeatureMap(); 
    for(Annotation annotation:team.inDocumentOrder())  
    {
        if(annotation.getType() == "Lookup"){
            features.put(annotation.getFeatures().get("majorType"),stringFor(doc,annotation));
        }
        else{
            features.put(annotation.getType(), stringFor(doc,annotation));
        }
    }
    features.put("rule","javainRHS1");  
    outputAS.add(team.firstNode(), team.lastNode(), "Team",features); 
}