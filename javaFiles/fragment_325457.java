TOKEN : {
  < (["0"-"9"])+ > : STATE_NUMBER
}

<STATE_NUMBER> TOKEN : {
  < number_with_exponent: "e" (["0"-"9"])+ > : DEFAULT
}

<STATE_NUMBER> MORE : {
  < number_without_exponent: "" > : DEFAULT
}