class ParentModel {
    StatusModel _status;
    ParentModel(@Inject StatusModel status) {
        _status = status;
        _status.setParent(this);
    }
}

class StatusModel {
    ParentModel _parent;
    void setParent(ParentModel parent) { _parent = parent);
}