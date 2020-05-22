for (int i = 0; i < arr.length; i++) {
  for (int a = 0; a < book.length; a++) {
    if (book[a].equalsIgnoreCase(arr[i])) {
//IF I TRY TO PRINT ARR[I] HERE IT HAS A VALUE
      bi = 1;
    }
  }
  if (bi != 1) {
    dif[l] = arr[i];
//HERE ARR[I] IS NULL
    System.out.println(arr[i]);
    l = l + 1;
  }
}