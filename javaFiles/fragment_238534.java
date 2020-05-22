public class SeminarLecture {
    ...
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "seminarLectures")
    public Set<Room> getRooms() {
        return this.rooms;
    }