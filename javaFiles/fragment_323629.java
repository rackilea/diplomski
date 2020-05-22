for(Map.Entry<Integer, Counter> entry : mProjectMap.entrySet()) {
    if(entry.getValue().getParent() != null) {
        ((ViewGroup) entry.getValue().getParent().removeView(entry.getValue());
    }
}

mLayoutRow = null;