ArrayList<Section> aMainSection = new ArrayList<Section>();
for(int i = 0; i < 3; i++)
{
    Section aSection = new Section();
    aSection.setName("Document "+(i+1));
    aSection.setSection("Section "+(i+1));
    aSection.setText("Text "+(i+1));
    aMainSection.Add(aSection);
}