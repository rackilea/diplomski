<svg style="width: 1812px; height: 995px;">
  <defs>

     <filter id="myfilter">
       <!-- Use feImage to get copies of each of the layers -->
       <feImage xlink:href="#layer1" result="lay1"/>
       <feImage xlink:href="#layer2" result="lay2"/>
       <feImage xlink:href="#layer3" result="lay3"/>
       <!-- The first operation finds the parts of layer1 that are "in" layer 3. Result is black dots. -->
       <feComposite operator="in" in="lay1" in2="lay3" result="lay1in3"/>
       <!-- The secong operation layers the previous result "atop" layer 2. Result is black dots on a green square. -->
       <feComposite operator="atop" in="lay1in3" in2="lay2"/>
     </filter>

  </defs>        

  <g transform="scale(5) rotate(0)" filter="url(#myfilter)">
    <!-- These layers are rendered, but later get overwritten by the result of the filter applied to the parent group. -->
    <path id="layer1" fill="rgba(0, 0, 0, 1)" stroke="rgba(0, 0, 0, 1)" stroke-width="0.0621761" 
          d="M 0 59.9999 
             L 59.9999 59.9999 
             L 59.9999 0 
             L 0 0 
             L 0 59.9999 Z" />
    <path id="layer2" fill="rgba(217, 217, 52, 1)" stroke="rgba(217, 217, 52, 1)" stroke-width="0.0621761" 
          d="M 0 59.9999 
             L 59.9999 59.9999 
             L 59.9999 0 
             L 0 0 
             L 0 59.9999 Z" />
    <path id="layer3" fill="rgba(227, 227, 227, 1)" stroke="rgba(227, 227, 227, 1)" stroke-width="0.0621761" 
          d="M 23.1 41.0363 
             C 23.1 40.1526 22.3837 39.4363 21.5 39.4363 
             C 20.6163 39.4363 19.9 40.1526 19.9 41.0363 
             C 19.9 41.92 20.6163 42.6363 21.5 42.6363 
             C 22.3837 42.6363 23.1 41.92 23.1 41.0363
             M 41.4481 41.0363 
             C 41.4481 40.1526 40.7318 39.4363 39.8481 39.4363 
             C 38.9644 39.4363 38.2481 40.1526 38.2481 41.0363 
             C 38.2481 41.92 38.9644 42.6363 39.8481 42.6363 
             C 40.7318 42.6363 41.4481 41.92 41.4481 41.0363 Z" />
  </g>
</svg>