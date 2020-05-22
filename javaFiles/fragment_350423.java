class MyActivity : AppCompatActivity() {

    override onAttachFragment(fragment: Fragment) {

           when (fragment) { //A switch statement, checking using instanceOf() in Java.
             is Fragment1 -> fragment.firstFragmentListener = this //Proviving context of your activity to public variable of each fragment.
             is Fragment2 -> fragment.secondFragmentListener = this
             is Fragment3 -> fragment.thirdFragmentListener = this
         }
     }
 }