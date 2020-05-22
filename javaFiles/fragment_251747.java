rule "Offer for A1"
    when
        offerObject: AssessmentLevel(assessment=="Null")
    then
        offerObject.setLevel("A1");
    end
rule "Offer for A2"
    when
        offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.setLevel("A2");
    end
rule "Offer for B1"
    when
        offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.setLevel("B1");
    end
rule "Offer for B2"
    when
        offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20]")
    then
        offerObject.setLevel("B2");
    end
rule "Offer for C1 "
    when
        offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25]")
    then
        offerObject.setLevel("C1");
    end
rule "Offer for C2"
    when
        offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.setLevel("C2");
    end
rule "Offer for recommend"
    when
        offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30] AND [31-35]")
    then
        offerObject.setLevel("Advanced");
    end
rule "Personalized Exercises  Intro to Computers and Programming"
    when
         offerObject: AssessmentLevel(assessment=="Null")
    then
        offerObject.getPersonalizedexercises().add("Intro Computers and Programming");
    end
rule "Personalized Exercises Logic"
    when
         offerObject: AssessmentLevel(assessment=="Null")
    then
        offerObject.getPersonalizedexercises().add("Logic");
    end
rule "Personalized Exercises Flowcharts and Algorithms"
    when
         offerObject: AssessmentLevel(assessment=="Null")
    then
        offerObject.getPersonalizedexercises().add("Flowcharts and Algorithms");
    end
rule "Personalized Exercises Pseudo Code"
    when
         offerObject: AssessmentLevel(assessment=="Null")
    then
        offerObject.getPersonalizedexercises().add("Pseudo Code");
    end
rule "Personalized Exercises Syntax"
    when
         offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.getPersonalizedexercises().add("Syntax");
    end
rule "Personalized Exercises Data Structure"
    when
         offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.getPersonalizedexercises().add("Data Structure");
    end
rule "Personalized Exercises Variables "
    when
         offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.getPersonalizedexercises().add("Variables");
    end
rule "Personalized Exercises Data Types"
    when
         offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.getPersonalizedexercises().add("Data Types");
    end
rule "Personalized Exercises Numbers"
    when
         offerObject: AssessmentLevel(assessment=="[1-10]")
    then
        offerObject.getPersonalizedexercises().add("Numbers");
    end
rule "Personalized Exercises Casting"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.getPersonalizedexercises().add("Casting");
    end
rule "Personalized Exercises Strings"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.getPersonalizedexercises().add("Strings");
    end
rule "Personalized Exercises Boolean"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.getPersonalizedexercises().add("Boolean");
    end
rule "Personalized Exercises Operators"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.getPersonalizedexercises().add("Operators");
    end
rule "Personalized Exercises Lists"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15]")
    then
        offerObject.getPersonalizedexercises().add("Lists");
    end
rule "Personalized Exercises  If Else"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20]")
    then
        offerObject.getPersonalizedexercises().add("If Else");
    end
rule "Personalized Exercises While Loops"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20]")
    then
        offerObject.getPersonalizedexercises().add("While Loops");
    end
rule "Personalized Exercises Functions"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20]")
    then
        offerObject.getPersonalizedexercises().add("Functions");
    end
rule "Personalized Exercises Arrays"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20]")
    then
        offerObject.getPersonalizedexercises().add("Arrays");
    end
rule "Personalized Exercises Classes/Objects"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25]")
    then
        offerObject.getPersonalizedexercises().add("Classes/Objects");
    end
rule "Personalized Exercises Dates"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25]")
    then
        offerObject.getPersonalizedexercises().add("Dates");
    end
rule "Personalized Exercises Modules"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25]")
    then
        offerObject.getPersonalizedexercises().add("Modules");
    end
rule "Personalized Exercises Try Accept"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25]")
    then
        offerObject.getPersonalizedexercises().add("Try Accept");
    end
rule "Personalized Exercises  User Input"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add(" User Input");
    end
rule "Personalized Exercises String Formating "
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add("String Formating ");
    end
rule "Personalized Exercises Database Basics "
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add("Database Basics ");
    end
rule "Personalized Exercises SQL Basics"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add("SQL Basics");
    end
rule "Personalized Exercises Intro to Object Oriented Programming"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add("Intro to Object Oriented Programming");
    end
rule "Personalized Exercises Information Systems"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30]")
    then
        offerObject.getPersonalizedexercises().add("Intro to Information Systems");
    end
rule "Personalized Exercises Recommend new courses"
    when
         offerObject: AssessmentLevel(assessment=="[1-10] AND [11-15] AND [16-20] AND [21-25] AND [26-30] AND [31-35]")
    then
        offerObject.getPersonalizedexercises().add("Brief about advanced courses");
    end