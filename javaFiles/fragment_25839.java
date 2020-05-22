double sum=0;

for(String str : w.split(" ")) {
    sum += Integer.parseInt(str);
}

return sum / w.split(" ").length;