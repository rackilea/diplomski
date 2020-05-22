public class LogList {
    public int _id;
    public boolean Checked;

    public LogList(int name, boolean status) {
        this._id = name;
        this.Checked = status;
    }

    public LogList(int name) {
        this._id = name;
    }

    public LogList() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
    }

    @Override
    public boolean equals(Object obj) {
        if (this._id == ((LogList) obj)._id)
            return true;
        return false;
    }
}