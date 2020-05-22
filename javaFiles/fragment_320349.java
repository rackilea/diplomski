CREATE TRIGGER delete_user
AFTER DELETE
ON jj_users
FOR EACH ROW
BEGIN
    ## delete the posts that belong to the user
    DELETE FROM jj_blog_posts WHERE author_user_id=OLD.user_id; # this delimiter is ignored
END
; # this delimiter is recognized