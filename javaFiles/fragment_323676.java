float dx = mouseX - x;
float dy = mouseY - y;
float dist = sqrt(dx*dx + dy*dy);
if (dist > 0) {
    float movelen = min(dist, speed);
    x += dx/dist * movelen;
    y += dy/dist * movelen;
}