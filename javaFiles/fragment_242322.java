INSERT INTO Songs
(SongID, SongName)
VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E');

INSERT INTO PlaylistDef
(PlaylistID, PlaylistName)
VALUES
(1, 'a'),
(2, 'b');


INSERT INTO Playlist
(PlaylistID, SongID)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 2),
(2, 3),
(2, 4),
(2, 5);