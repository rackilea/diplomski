tmr.setView(camera);
tmr.render();
camera.update();
b2dCam.update();
b2dr.render(world, b2dCam.combined);

cntrlOverlay.act();
cntrlOverlay.draw();
world.step(1 / 60f, 6, 2);