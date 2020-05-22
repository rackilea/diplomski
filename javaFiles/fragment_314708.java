<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Google Maps APIs</title>

        <link href="style.css" rel="stylesheet">

        <style>
            html,
            body {
                height: 200px;
                width: 100%;
                margin: 0;
                padding: 0;
            }
        </style>
    </head>
    <body onload="initMap2();">


        <sql:setDataSource
            var="myDS"
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/mess"
            user="root" password=""
            />

        <sql:query var="listUsers" dataSource="${myDS}">
            SELECT * FROM latlang;
        </sql:query>

        <div align="center">
            <select id="messname">
                <c:forEach var="user" items="${listUsers.rows}">
                    <option><c:out value="${user.messname}" /></option1>
                    </c:forEach>
            </select>
            <select id="lat">
                <c:forEach var="user" items="${listUsers.rows}">
                    <option><c:out value="${user.lat}" /></option>
                </c:forEach>
            </select>
            <select id="lang">
                <c:forEach var="user" items="${listUsers.rows}">
                    <option><c:out value="${user.lang}" /></option2>
                    </c:forEach>

            </select>

            <c:forEach var="user" items="${listUsers.rows}">

                <button><a onclick="showMarkers();">${user.messname}</a></button>
                </c:forEach>  

        </div>               
        <script>
        </script>
        <sql:query var="result" dataSource="${myDS}" >

            SELECT * from latlang;
        </sql:query>
        <script>


            var map;
      var markers = [];

      function initMap() {
          
          var mrks = [
            <c:forEach var="row" items="${result.rows}">
                    ['<c:out value="${row.messname}" />',
                <c:out value="${row.lat}" />,
                <c:out value="${row.lang}" />,
                    ],
            </c:forEach>];

        //var haightAshbury = {lat: 37.769, lng: -122.446};

        map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: {lat: 18.5204, lng: 73.8567},
          mapTypeId: 'terrain'
        });

        // This event listener will call addMarker() when the map is clicked.
          
        // Adds a marker at the center of the map.
        for(var i=0; i<mrks.length; i++)
        {   
                var pos = new google.maps.LatLng(mrks[i][1], mrks[i][2]);
                addMarker(pos);
        }
     }

      // Adds a marker to the map and push to the array.
      function addMarker(location) {
        var marker = new google.maps.Marker({
          position: location,
          map: map
        });
        markers.push(marker);
      }

      // Sets the map on all markers in the array.
      function setMapOnAll(map) {
        for (var i = 0; i < markers.length; i++) {
          markers[i].setMap(map);
        }
      }

      // Removes the markers from the map, but keeps them in the array.
      

      // Shows any markers currently in the array.
      function showMarkers() {
        setMapOnAll(map);
      }

      // Deletes all markers in the array by removing references to them.
        </script>

        <p><td>  </td></p>

<input type="text" id="searchvalue">

<input type="button" id="btn" value="Click" onclick="">        
<%-- //>--%>

<div id="map" style="height:200px; width:200px"></div>
<p>


    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBN1fnarI5qrCYI7gS6ksuX3L7jHGTq2MY&callback=initMap"></script>
</body>

</html>