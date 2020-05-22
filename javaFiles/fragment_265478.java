@Override
public Parcelable onSaveInstanceState() {
    Parcelable superState = super.onSaveInstanceState();
    SavedState ss = new SavedState(superState);  
    ss.childrenStates = new SparseArray();  
    for (int i = 0; i < getChildCount(); i++) {  
        getChildAt(i).saveHierarchyState(ss.childrenStates);
    }  
    return ss;
}

@Override
public void onRestoreInstanceState(Parcelable state) {
    SavedState ss = (SavedState) state;
    super.onRestoreInstanceState(ss.getSuperState());  
    for (int i = 0; i < getChildCount(); i++) {  
        getChildAt(i).restoreHierarchyState(ss.childrenStates);
    }  
}

@Override
protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
    dispatchFreezeSelfOnly(container);
}

@Override
protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
    dispatchThawSelfOnly(container);
}

static class SavedState extends BaseSavedState {
    SparseArray childrenStates;

    SavedState(Parcelable superState) {  
        super(superState);
    }

    private SavedState(Parcel in, ClassLoader classLoader) {
        super(in);
        childrenStates = in.readSparseArray(classLoader);  
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeSparseArray(childrenStates);  
    }

    public static final ClassLoaderCreator<SavedState> CREATOR
            = new ClassLoaderCreator<SavedState>() {
        @Override
        public SavedState createFromParcel(Parcel source, ClassLoader loader) {
            return new SavedState(source, loader);
        }

        @Override
        public SavedState createFromParcel(Parcel source) {
            return createFromParcel(source, null);
        }

        public SavedState[] newArray(int size) {
            return new SavedState[size];
        }  
    };
}