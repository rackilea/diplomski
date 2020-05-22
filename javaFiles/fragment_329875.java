Submission res = null;
for (Submission sub : this.students) {
    if (sub.getUnikey().equals(unikey)) {
        if (sub.getTime().before(deadline) && 
                (res == null || sub.getTime().after(res.getTime()))) {
            res = sub;
        }
    }
}
return res;