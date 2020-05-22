class BaseVO {
    String id;
    String name;

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }
}

class NoteVO extends BaseVO {
    // ...
}

@Data
class BaseDocument {
    String id;
    String name;
    //Other fields

    protected void populateBaseVO(BaseVO vo) {
        vo.setId(id);
        vo.setName(name);
    }

    public BaseVO getVO() {
        BaseVO vo = new BaseVO();

        populateBaseVO(vo);
        return vo;
    }
}

@Data
class NoteDocument extends BaseDocument {
    String description;
    Long lastModifiedDate;
    // ....

    protected void populateNoteVO(NoteVO vo) {
        populateBaseVO(vo);
        // ...
    }

    public NoteVO getVO() {
        NoteVO vo = new NoteVO();

        populateNoteVO(vo);
        return vo;
    }
}