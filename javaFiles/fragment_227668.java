public InputData(OutputData outputData){
     // ...
     List<Section> copiedSections = new ArrayList<>();
     for (Section section : outputData.getSections()){
           Section copiedSection = new Section(section); // copy constructor
           copiedSections.add(copiedSection);
     }
     this.sections = copiedSections;    
}