Student newStd = new Student(name, last, score);


                for(int i=0;studentList.size()>i;i++)
                {
                    int size = studentList.size();
                    if(newStd.compareToCustom(studentList.get(i))>0)
                    {
                        studentList.add(i, newStd);
                        break;
                    }
                    else if(newStd.compareToCustom(studentList.get(size-1))<0)
                    {
                        studentList.add(studentList.size(), newStd);
                        break;
                    }
                    else if(newStd.compareToCustom(studentList.get(i))==0)
                    {
                        studentList.add(i++, newStd);
                        break;
                    }
                }