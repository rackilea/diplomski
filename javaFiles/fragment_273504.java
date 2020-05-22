rule "is my dog a baby?"
    ruleflow-group "dog"
    salience 10
    when 
        dog : Dog(age < 1, baby == false)
        myData : MyData(myDog == dog)
    then
        dog.setIsBaby(true);
        update(dog);
        update(myData);
    end