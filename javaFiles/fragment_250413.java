For i=0 till names.length
   print names[i]
   total=0
   For j=0 till scores[i].length
      print scores[i][j]
      total=total+scores[i][j]
   End For
   Print Average = total/scores[i].length;
   decide Grade on basis of average and print
End For