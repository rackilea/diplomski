class MyActivity : AppCompatActivity(), MyInterface {

   override fun onSomethingDone(someData: Int) {
      when (someData) {
         999 -> //Came from first fragment
         1000 -> //Second fragment
         1001 -> //Third fragment
      }
    }

    override onAttachFragment(fragment: Fragment) {

           when (fragment) { //A switch statement, checking using instanceOf() in Java.
             is Fragment1 -> firstFragmentListener = this //Proviving context of your activity to public variable of each fragment.
             is Fragment2 -> secondFragmentListener = this
             is Fragment3 -> thirdFragmentListener = this
         }
     }
 }