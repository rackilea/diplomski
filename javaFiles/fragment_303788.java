(function onLoad() {
  var camera, scene, renderer, orbitControls;
  
  init();
  animate();

  function init() {
    
    renderer = new THREE.WebGLRenderer({
      antialias: true,
      alpha: true
    });

    renderer.setPixelRatio(window.devicePixelRatio);
    renderer.setSize(window.innerWidth, window.innerHeight);
    renderer.shadowMap.enabled = true;
    document.body.appendChild(renderer.domElement);

    camera = new THREE.PerspectiveCamera(70, window.innerWidth / window.innerHeight, 1, 300);
    camera.position.set(10, 15, -60);

    loader = new THREE.TextureLoader();
    loader.setCrossOrigin("");

    scene = new THREE.Scene();
    scene.background = new THREE.Color(0xffffff);
    scene.add(camera);
    window.onresize = resize;
    
    orbitControls = new THREE.OrbitControls(camera, renderer.domElement);
    
    var helper = new THREE.GridHelper(400, 10);
    helper.material.opacity = 0.25;
    helper.material.transparent = true;
    scene.add(helper);

    var axis = new THREE.AxesHelper(1000);
    scene.add(axis);
    
    var material = new THREE.ShaderMaterial({  
          vertexShader: document.getElementById('vertex-shader').textContent,
          fragmentShader: document.getElementById('fragment-shader').textContent,
    });
    material.extensions = {
      derivatives: true
    }

    var geometry = new THREE.BoxGeometry( 100, 0.1, 100 );
    var mesh = new THREE.Mesh(geometry, material);
    scene.add(mesh);
  }

  function resize() { 
    var aspect = window.innerWidth / window.innerHeight;
    renderer.setSize(window.innerWidth, window.innerHeight);
    camera.aspect = aspect;
    camera.updateProjectionMatrix();
  }

  function animate() {
    requestAnimationFrame(animate);
    orbitControls.update();
    render();
  }

  function render() {
    renderer.render(scene, camera);
  }
})();