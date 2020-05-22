while (saveNameReader.hasNext()) {

  nameTemp = saveNameReader.next();

  //   if line in file contains #, skip the line
  if (nameTemp.startsWith("#"))
  {
    saveNameReader.nextLine();
    continue;
  }

  idTemp = saveNameReader.nextInt();
  saveNames.add(nameTemp);
  sessionIDs.add(idTemp);
}