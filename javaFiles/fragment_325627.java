Immutable imm = new Immutable("John", new Date());

imm.getName(); //safe
Date dateOfBirth = imm.getDateOfBirth();
//hundreds of lines later
dateOfBirth.setTime(0);  //we just modified `imm` object