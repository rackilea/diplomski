//execution 1
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "2", firstName: "von", lastName: "", result: "[]");

stack = [execution1];

//execution 2
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "von", lastName: "", result: "[]");

stack = [execution1, execution2];

// nameIndex >= nameArray.length -> step 2 -> step3
stack = [execution1];   

// execution 3
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "von", lastName + "." + nameArray[nameIndex]: ".smith", result: "[]");

stack = [execution1, execution3];

// nameIndex >= nameArray.length -> step 2 -> step3
stack = [execution1];   

//execution 4
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "2", firstName: "von", lastName + "." + nameArray[nameIndex]: ".del", result: "[von.smith]");

stack = [execution1,execution4];   


// exectution 5
// we are back at step 1
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "von", lastName: ".del", result: "[von.smith]");

stack = [execution1,execution4,execution5];   

// nameIndex >= nameArray.length -> step 2 -> step3    
stack = [execution1,execution4];   

// execution 6
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "von", lastName + "." + nameArray[nameIndex]: ".del.smith", result: "[von.smith, von.del]");

stack = [execution1,execution4,execution6];  

// nameIndex >= nameArray.length -> step 2 -> step3    
stack = [execution1,execution4];   

// execution 7
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "del", lastName: "", result: "[von.smith, von.del, von.del.smith]");

stack = [execution1,execution4,execution7];  

// nameIndex >= nameArray.length -> step 2 -> step3 
stack = [execution1];  

// execution 8
buildNameChoicesHelper(nameArray: [von, del, smith],nameIndex: "3", firstName: "del", lastName + "." + nameArray[nameIndex]: ".smith", result: "[von.smith, von.del, von.del.smith]");

stack = [execution1, execution8];  

//1 and 8 both terminate