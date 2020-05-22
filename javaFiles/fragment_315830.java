PrintWriter write = new PrintWriter(new FileOutputStream(path,
            append));
StringBuilder sb = new StringBuilder();
for (SuperObject o : this.list) {
    if (o instanceof Object1) {
        ((subObject1) w).writer1(sb);
    }
    if (o instanceof Object2) {
        ((subObject3) w).writer2(sb);

    } if (o instanceof Object3) {
        ((subObject3) w).writer3(sb);

    }
}

write.append(sb.toString());
write.close();