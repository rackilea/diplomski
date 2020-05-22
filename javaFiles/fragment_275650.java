while (rCST.next()) {
                    StudentModel  rM = new StudentModel ();
                    rM.setStudentId(rCST.getInt(1));
                    rM.setStudentName(rCST.getString(2));
                    students.add(rM);
                }