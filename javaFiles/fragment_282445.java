ExcelDataConfig config=new ExcelDataConfig(Excel Path);

//Arguments - Sheet Index, Row Number , column Number(All the index starts from 0.So, give the no of is correctly
config.getData(0,1,1)

// To write the Rate Details in Excel
config.writeData(0,1,2);

// To write the Time Details in Excel
config.writeData(0,1,3);