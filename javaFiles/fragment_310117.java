abstract class BaseFragment : Fragment() {
  abstract val showBottomNavBar: Boolean
  //.. your other stuff
}

class FragmentA : BaseFragment() {
  override val showBottomNavBar = false

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    if (!showBottomNavBar) {
      (requireActivity() as YourAcitivy).hideNavBar() //this is bad
      someKindOfBroadcastManager.sendEvent(hideNavBar) // this is somewhat better
    }
  }
}