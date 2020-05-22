String temp1=tvLecTime1.getText().toString();
String temp2=tvLecTime2.getText().toString();
String temp3=tvLecTime3.getText().toString();
String temp4=tvLecTime4.getText().toString();
String temp5=tvLecTime5.getText().toString();
String temp[]={temp1,temp2,temp3,temp4,temp5};

TextView[] tcLectures = { tvLecture1, tvLecture2, tvLecture3, tvLecture4, tvLecture5 };
TextView[] tvHalls = { tvHall1, tvHall2, tvHall3, tvHall4, tvHall5 };

for(int i=0; i<5; i++){

    lecTime=temp[i];
    final currentIndex = i;

    requestServerForTimeTable.fetchLectureDataInBackgroundEditTimeTable(
           day, year, lecTime,
           new GetLectureCallBack() {

                @Override
                public void done(LectureDetails lectureDetailsReturned) {

                    lectureLocalDatabase.storeData(lectureDetailsReturned);
                    LectureDetails lectureDetailsReceivedFromSP = 
                                          lectureLocalDatabase.getDataBack();
                    tcLectures[currentIndex].setText(
                              lectureDetailsReceivedFromSP.courseId);
                    tvHalls[currentIndex].setText(
                              lectureDetailsReceivedFromSP.hall);

                }
          });
}