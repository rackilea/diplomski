//on drawing:
prev.set(current);
current.x = (float) ((Math.cos(t) / (1 + Math.sin(t)*Math.sin(t))));
current.z = (float) ((Math.cos(t) * (Math.sin(t))) / (1 + Math.sin(t)*Math.sin(t)));

glu.gluLookAt(current.x, 0f, current.z,
              current.x - prev.x, 0f, current.z - prev.z,
              0f, 1f, 0f);