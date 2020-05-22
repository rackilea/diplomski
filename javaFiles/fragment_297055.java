public View getView(int position, View convertView, ViewGroup parent) {
    Renderer result = null;
    WeakReference<Renderer> wr = (WeakReference<Renderer>) _renderers[position];
    if (ref != null)
        result = wr.get();

    if (result == null) {
        result = new Renderer(_context);
        // set the texts here and start loading your images
        _renderers[position] = new WeakReference<Renderer>(result);
    }
    return result;
}