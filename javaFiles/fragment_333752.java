for (Fragment frag : fragmentsList) { 
    if (frag.isActuallyVisible) {
        frag.doSearch(query);
        break;
    }
}