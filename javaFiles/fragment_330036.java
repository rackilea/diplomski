Repository repo = ...

RevWalk walk = new RevWalk(repo);
NoteMap map = NoteMap.newEmptyMap();
Ref ref = repo.getRef("refs/notes/commits");

if (ref != null) {
  RevCommit notesCommit = walk.parseCommit(ref.getObjectId());
  map = NoteMap.read(walk.getObjectReader(), notesCommit);
  map.getNote(notesCommit.getId());
}