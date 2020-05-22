//Folder, which holds zero or more documents
interface Folder<D extends Document<D, F>, F extends Folder<D, F>> {
    ArrayList<D> findDocuments();
}

// Document, contained within a folder
interface Document<D extends Document<D, F>, F extends Folder<D, F>> {
    F getFolder();
}