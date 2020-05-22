static int do_push(const char *repo, int flags)
    {
        int i, errs;
        struct remote *remote = remote_get(repo);

        const char **url;
        int url_nr;


        if (!remote) {
            if (repo)
                die("bad repository '%s'", repo);
            die("No destination configured to push to.");
        }