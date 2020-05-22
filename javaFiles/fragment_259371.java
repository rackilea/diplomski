while($row_Slider=mysql_fetch_array($Query_Sliders)){

   $QuestionID[]=$row_Slider['QuestionIDFK']; //used $QuestionID[], instead of $QuestionID

   //$AnswerID=$row_Slider['AnswerIDPK'] ;
   //$AnswerValue=$row_Slider['AnswerValue'] ;
   //$SortOrder=$row_Slider['SortOrder'] ;


  //$tableslidersqid[] = array($QuestionID);

  //if($QuestionID != $currentQuestionID){
     //$tableslidersREALqid[] = array($QuestionID);
     //$CurrentQuestionID = $QuestionID;
  //}
}

$result = array_unique($QuestionID); //make array unique here, after all the ids are in the array