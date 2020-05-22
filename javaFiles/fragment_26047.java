ArrayList<Section> aMainSection = new ArrayList<Section>();
int sectionNumber = 1;
boolean done = false;
while(!done)
{
    Section aSection = new Section();
    aSection.setName("Document "+ sectionNumber);
    aSection.setSection("Section "+ sectionNumber);
    aSection.setText("Text "+ sectionNumber);
    aMainSection.Add(aSection);

    sectionNumber++;
    done = <put something interesting here>
}