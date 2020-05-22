File inp = new File("H://"+file_name);
File out = new File("H://"+file_name);
Workbook existingWorkbook = Workbook.getWorkbook(inp);// This opens up a read-only copy of the workbook
WritableWorkbook copy = Workbook.createWorkbook(out,existingWorkbook); // This opens up a writable workbook so that we can edit the copy
//..........Some writes to excel workbook...........
// Now before writing & closing the copy, first close the existing one
existingWorkbook.close();    // Important: Close it before writing the copy with copy.write();
inp.close();
copy.write();
copy.close();