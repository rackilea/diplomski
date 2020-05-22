TOKEN : {
  < (["0"-"9"])+ > : STATE_NUMBER0
}

<STATE_NUMBER0> TOKEN : {
  < "e" > : STATE_NUMBER1
}

<STATE_NUMBER0> MORE : {
  < number_without_exponent: "" > : DEFAULT
}

<STATE_NUMBER1> MORE : {
   < number_with_exponent: (["0"-"9"])+ > : DEFAULT
}