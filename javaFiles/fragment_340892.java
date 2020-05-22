// First pop B
fragmentManager.popBackStack("b", FragmentManager.POP_BACK_STACK_INCLUSIVE)
// Then addToBackStack C
fragmentManager.beginTransaction()
    .replace(R.id.fragmentContainer, fragmentC)
    .addToBackStack("c")
    .commit();