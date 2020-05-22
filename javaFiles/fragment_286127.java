void TrySomething() {
   try {


   } catch (ArgumentException) {
        HandleTrySomethingFailure();
   }
}

void HandleTrySomethingFailure() {
    try {

    } catch (IndexOutOfRangeException) {

    }
}