public DataField(T val) throws IllegalValueException {
        if(val==null) throw  new IllegalArgumentException("Class type couldn't be resolved from null");
        _value =val;
        _class=val.getClass();
        _hasChanged=false;
        _hasChangedObserverable=new ChildObserable<>();
    }
    public DataField(T val,Class<T> classType) throws IllegalValueException {
        if(val!=null &&  val.getClass()!=classType) throw  new IllegalArgumentException("Type of val and classType are Different");
        _class=classType;
        _value=val;
        _hasChanged=false;
        _hasChangedObserverable=new ChildObserable<>();
    }


@Override
    public void setValue(T value) throws IllegalValueException {
        if(_class!= value.getClass()) throw new IllegalValueException();
        if(value!=_value) {
            _value = value;
            _hasChanged=true;
            _hasChangedObserverable.sendValue(_value);
        }
    }