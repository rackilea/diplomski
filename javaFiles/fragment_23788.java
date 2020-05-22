static void transferDogProps(List<Dog> dogList, List<DogProp> dogPropList){
    Dictionary<String,Dog> dogDictionary = new Dictionary<String,Dog>();
    Dictionary<String,DogProp> dogPropDictionary = new Dictionary<String,DogProp>();
    foreach(Dog dog in dogList) dogDictionary.Add(dog.getId(),dog);
    foreach(Dog dogProp in dogPropList) dogPropDictionary.Add(dogProp.getId(),dogProp);
    foreach(String id in dogPropList.Keys){
        if(dogDictionary.ContainsKey[id]){
            Dog matchingDog = dogDictionary[id];
            DogProp matchingDogProp = dogPropDictionary[id];
            matchingDog.setNewValue(matchingDogProp.getNewValue());
        }
    }
}