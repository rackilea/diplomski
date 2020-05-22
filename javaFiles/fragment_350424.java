class Fragment1 : Fragment() {

     var firstFragmentListener: MyInterface? =  null  //public member, we are accessing it in our activity method, look above! 

      override onCreate() {

          myButton.setOnClickListener {
              firstFragmentListener.onSomethingDone(999) // Just sending random integer as the method parameter.
           }
       }
  }